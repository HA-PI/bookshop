/**
 * Created by moyu on 2017/6/9.
 */

var path = require('path');
var fs = require('fs');

var gulp = require('gulp'),
    // watch = require('gulp-watch'),
    autoprefixer = require('gulp-autoprefixer'),
    sourcemap = require('gulp-sourcemaps'),
    // copy = require('gulp-copy'),
    babel = require('gulp-babel'),
    noop = require('gulp-noop'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    coffee = require('gulp-coffee'),
    rename = require('gulp-rename'),
    less = require('gulp-less');

var watchify = require('watchify');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var babelify = require('babelify');


__DEV__ = (!gulp.env.prod);
console.log('__DEV__=', __DEV__);

var outdir = "../../web/asset/",
    indir = ".";

const COMMON_VENDER = ['jquery', 'bootstrap', 'babel-polyfill', 'dialog'];

function compileCMD(file, watched) {
    var customOpts = {
        // entries: fs.readdirSync(indir+"js").map(x => path.join(indir, "js", x)),
        // entries: ['src/js/bundle.js'],
        browserField: true,
        debug: __DEV__
    };
    var opts = Object.assign({}, watchify.args, customOpts);
    var b = browserify(file, opts).transform(babelify, {presets: ["es2015", "stage-0"]});
    b = COMMON_VENDER.reduce((obj, file) => {
        if (typeof file === 'string') {
            return obj.exclude(file);
        }
        return obj.exclude(file.file).exclude(file.expose);
    }, b);
    if (__DEV__ && !watched) {
        b = watchify(b);
        b.on('update', function () {
            console.log('-> compiling CMD Module -> ' + file);
            compileCMD(file);
        });
    }

    return b.bundle()
        .on('error', function (err) {
            console.error(err);
            this.emit('end');
        })
        .pipe(source(path.basename(file).replace(/\.[^\.]*$/, '') + '.min.js'))
        // 可选项，如果你不需要缓存文件内容，就删除
        .pipe(buffer())
        .pipe(sourcemap.init({loadMaps: true}))
        .pipe(__DEV__ ? noop() : uglify({
            // mangle: {except: ['require' ,'exports' ,'module' ,'$']}
        }))
        .pipe(sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, '/js')));
}

gulp.task('bundle', function () {
    return COMMON_VENDER.reduce((bowser, a) => {
        if (typeof a === 'string') {
            return bowser.require(a);
        }
        return bowser.require(a.file, a);
    }, browserify('index', {
        debug: __DEV__,
        browserField: true,
    }))
        .transform(babelify)
        // .require('./src/lib/dialog', {expose: 'my-dialog'})
        .bundle()
        .on('error', function (err) {
            console.error(err);
            this.emit('end');
        })
        .pipe(source('bundle.min.js'))
        // 可选项，如果你不需要缓存文件内容，就删除
        .pipe(buffer())
        .pipe(sourcemap.init({loadMaps: true}))
        .pipe(__DEV__ ? noop() : uglify({
            // mangle: {except: ['require' ,'exports' ,'module' ,'$']}
        }))
        .pipe(sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, 'js')));
})

gulp.task('compile-js', function () {
    let js_path = path.join(indir, 'js');

    fs.readdirSync(js_path).filter(x => x.endsWith('.js')).map(x => path.join(js_path, x)).map(x => compileCMD(x));
});

gulp.task('compile-coffee', function () {
    return gulp
        .src(path.join(indir, '/coffee/**/*.coffee'))
        .pipe(sourcemap.init({loadMaps: true}))
        .pipe(coffee({}))
        // .pipe(__DEV__ ? noop() : uglify())
        .pipe(sourcemap.write('./'))
        .pipe(gulp.dest(path.join(indir, "js")))
});

gulp.task('default', function () {
    __DEV__ = false;
    return gulp.start(['compile-less', 'compile-coffee', 'bundle', 'copy-static', 'bower2static', 'compile-bootstrap-less', 'compile-js']);
});

gulp.task('watch-compile-less', function () {
    gulp.watch(path.join(indir, 'less/**/*.less'), ['compile-less']);
});
gulp.task('watch-compile-coffee', function () {
    gulp.watch(path.join(indir, '/coffee/**/*.coffee'), ['compile-coffee']);
});

// gulp.task('watch-compile-js', function () {
//     gulp.watch(path.join(indir, 'js/**/*.js'), ['compile-js']);
// });

gulp.task('watch', function () {
    __DEV__ = true;
    gulp.start('watch-compile-less', 'watch-compile-coffee', 'compile-js', 'watch-compile-bootstrap-less');
});


gulp.task('bower2static', function () {
    const name = '../bower_components';
    const dirs = fs.readdirSync(name).filter(filename => fs.statSync(path.join(name, filename)).isDirectory()).map(x => path.join(name, x));
    const js_set = dirs.reduce((set, d) => {
        let main = require(path.resolve(d, 'bower.json')).main;
        if (Array.isArray(main)) {
            main = main.map(x => path.join(d, x));
        } else {
            main = path.join(d, main || 'index.js');
        }
        return set.concat(main);
    }, []);

    return gulp
        .src(js_set)
        .pipe(gulp.dest(path.join(outdir, "static")))
});

gulp.task('watch-compile-bootstrap-less', function () {
    return gulp
        .watch(path.join(__dirname, '/node_modules/bootstrap/less/**/*.less'), ['compile-bootstrap-less']);
});

gulp.task('compile-less', function compileLess() {
    return gulp
        .src(path.join(indir, '/less/**/*.less'))
        .pipe(sourcemap.init({loadMaps: true}))
        .pipe(less({
            compress: !__DEV__
        }))
        .pipe(autoprefixer({
            browsers: ['last 2 versions'],
        }))
        .pipe(rename((path) => {
            path.basename += '.min'
        }))
        .pipe(sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, "css")))
});

gulp.task('compile-bootstrap-less', function compileLess() {
    return gulp
        .src(path.join(__dirname, '/node_modules/bootstrap/less/bootstrap.less'))
        .pipe(sourcemap.init({loadMaps: true}))
        .pipe(less({
            compress: !__DEV__
        }))
        .pipe(autoprefixer({
            browsers: ['last 2 versions'],
        }))
        .pipe(rename((path) => {
            path.basename += '.min'
        }))
        .pipe(sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, "css")))
});

// gulp.task('compile-js', function compileJs() {
//     return gulp
//         .src(path.join(indir, '/js/**/*.js'))
//         .pipe(sourcemap.init({loadMaps: true}))
//         .pipe(babel())
//         .pipe(sourcemap.write('./'))
//         .pipe(gulp.dest(path.join(outdir, "js")))
// });

gulp.task('copy-static', function () {
    return gulp
        .src(path.join(indir, '/static/*'))
        .pipe(gulp.dest(path.join(outdir, 'static')))
});