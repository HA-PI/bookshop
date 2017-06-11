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

var browserSync = require('browser-sync').create();
var watchify = require('watchify');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var babelify = require('babelify');

var browser_conf = require('./browser.conf');

__DEV__ = (!gulp.env.prod);
console.log('__DEV__=', __DEV__);

const toArr = function (o) {
    if (!o) return o;
    if (Array.isArray(o)) {
        return o;
    } else {
        return [o];
    }
};

var outdir = path.join(__dirname, "../../web/asset/"),
    indir = path.join(__dirname, ".");

var __write = sourcemap.write
sourcemap.write = function (dir, opts) {
    opts = Object.assign({includeContent: true}, opts)
    return dir ? __write(dir, opts) : __write(opts)
}

let babel_enable = gulp.env.babel;
let requires = toArr(gulp.env.r || gulp.env.require), bundle_file = 'bundle.min.js';
let COMMON_VENDER = browser_conf.vender;
let EXCLUDES = browser_conf.excludes;

if (requires) {
    let basename = path.basename;
    bundle_file = gulp.env.o || gulp.env.out || ( basename(requires[0])+'.min.js' );
}

console.log('babel_enable', babel_enable);
console.log('requires', requires);
console.log('COMMON_VENDER', COMMON_VENDER);
console.log('EXCLUDES', EXCLUDES);
console.log('bundle_file', bundle_file);

function compileCMD(file, watched) {
    var customOpts = {
        browserField: true,
        debug: __DEV__
    };
    var opts = Object.assign({}, watchify.args, customOpts);
    var b = browserify(file, opts).transform(babelify);
    b = EXCLUDES.reduce((obj, file) => {
        if (typeof file === 'string') {
            return obj.exclude(file);
        }
        return obj.exclude(file.file).exclude(file.expose);
    }, b);
    if (__DEV__ && !watched) {
        b = watchify(b);
        b.on('update', function () {
            console.log('-> compiling CMD Module -> ' + file);
            // browserSync.reload();
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
        .pipe(!__DEV__ ? noop() : sourcemap.init({loadMaps: true}))
        .pipe(__DEV__ ? noop() : uglify({
            // mangle: {except: ['require' ,'exports' ,'module' ,'$']}
        }))
        .pipe(!__DEV__ ? noop() : sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, '/js')));
}

gulp.task('browser-sync', function() {
    browserSync.init({
        proxy: {
            target: "http://localhost:8080",
            ws: false
        },
        ui: {
            weinre: {
                port: 9090
            }
        }
    });
});

gulp.task('watch-jsp', function() {
    let tomcat_home = fs.readFileSync('../../tomcat_home').toString();
    let proj_name = fs.readFileSync('../../project_name').toString();
    let base = tomcat_home+'/webapps/'+proj_name;

    let reloading = false, time;
    return gulp.watch([
        base+'/**/*.jsp', base+'/**/*.js', base+'/**/*.css', base+'/**/*.html',
        base+'/**/*.jar', base+'/**/*.html', base+'/**/*.class'
    ]).on('change', function (file) {
        if (!reloading) {
            console.log('[CHANGED]', file);
            if (time!=null) clearTimeout(time);
            time = setTimeout(function () {
                browserSync.reload();
            }, 1000);
            reloading = true;
            setImmediate(function () {
                reloading = false;
            })
        }
    })
});

gulp.task('bundle', function () {
    let bundle = (requires || COMMON_VENDER).reduce((bowser, a) => {
        if (typeof a === 'string') {
            return bowser.require(a);
        }
        return bowser.require(a.file, a);
    }, browserify(!requires?'index':null, {
        debug: __DEV__,
        browserField: true,
    }));

    if (requires) {
        bundle = COMMON_VENDER.reduce((obj, file) => {
            if (typeof file === 'string') {
                return obj.exclude(file);
            }
            return obj.exclude(file.file).exclude(file.expose);
        }, bundle);
    }

    if (!requires || babel_enable) {
        bundle = bundle.transform(babelify);
    }

    return bundle.bundle()
        .on('error', function (err) {
            console.error(err);
            this.emit('end');
        })
        .pipe(source(bundle_file))
        // 可选项，如果你不需要缓存文件内容，就删除
        .pipe(buffer())
        .pipe(!__DEV__ ? noop() : sourcemap.init({loadMaps: true}))
        .pipe(__DEV__ ? noop() : uglify({
            // mangle: {except: ['require' ,'exports' ,'module' ,'$']}
        }))
        .pipe(!__DEV__ ? noop() : sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, 'js')));
})

gulp.task('compile-js', function () {
    let js_path = path.join(indir, 'js');

    fs.readdirSync(js_path).filter(x => x.endsWith('.js')).map(x => path.join(js_path, x)).map(x => compileCMD(x));
});

gulp.task('compile-coffee', function () {
    return gulp
        .src(path.join(indir, '/coffee/**/*.coffee'))
        // .pipe(!__DEV__ ? noop() : sourcemap.init({loadMaps: true}))
        .pipe(coffee({}))
        // .pipe(__DEV__ ? noop() : uglify())
        // .pipe(!__DEV__ ? noop() : sourcemap.write('./'))
        .pipe(gulp.dest(path.join(indir, "js")))
});

gulp.task('proxy-hrs', function (cb) {
    require('child_process').spawn("hrs", {
        cwd: path.join(__dirname, '../..'),
        stdio: [ 'ignore', 1, 2 ]
    }).on('exit', function (code, signal) {
        cb();
    }).on('error', function (err) {
        cb(err);
    })
});

gulp.task('default', function () {
    __DEV__ = false;
    return gulp.start(['compile-less', 'compile-coffee', 'bundle', 'copy-static', 'bower2static', 'compile-bootstrap-less', 'compile-js']);
});

gulp.task('watch-compile-less', function () {
    gulp.watch(path.join(indir, 'less/**/*.less'), ['compile-less']);
});
gulp.task('watch-compile-coffee', function () {
    gulp.watch(path.join(indir, '/coffee/**/*.coffee'), ['compile-coffee'])
});

// gulp.task('watch-compile-js', function () {
//     gulp.watch(path.join(indir, 'js/**/*.js'), ['compile-js']);
// });

gulp.task('watch', function () {
    __DEV__ = true;
    gulp.watch('./browser.conf.js', function () {
        delete require.cache[require.resolve('./browser.conf')];
        browser_conf = require('./browser.conf');
        COMMON_VENDER = browser_conf.vender;
        EXCLUDES = browser_conf.excludes;
        console.log('COMMON_VENDER', COMMON_VENDER);
        console.log('EXCLUDES', EXCLUDES);
    });
    gulp.start('watch-compile-less', 'watch-compile-coffee', 'compile-js', 'watch-compile-bootstrap-less', 'watch-jsp', 'proxy-hrs', 'browser-sync');
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
        .pipe(!__DEV__ ? noop() : sourcemap.init({loadMaps: true}))
        .pipe(less({
            compress: !__DEV__
        }))
        .pipe(autoprefixer({
            browsers: ['last 2 versions'],
        }))
        .pipe(rename((path) => {
            path.basename += '.min'
        }))
        .pipe(!__DEV__ ? noop() : sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, "css")))
});

gulp.task('compile-bootstrap-less', function compileLess() {
    return gulp
        .src(path.join(__dirname, '/node_modules/bootstrap/less/bootstrap.less'))
        .pipe(!__DEV__ ? noop() : sourcemap.init({loadMaps: true}))
        .pipe(less({
            compress: !__DEV__
        }))
        .pipe(autoprefixer({
            browsers: ['last 2 versions'],
        }))
        .pipe(rename((path) => {
            path.basename += '.min'
        }))
        .pipe(!__DEV__ ? noop() : sourcemap.write('./'))
        .pipe(gulp.dest(path.join(outdir, "css")))
});


gulp.task('copy-static', function () {
    return gulp
        .src(path.join(indir, '/static/*'))
        .pipe(gulp.dest(path.join(outdir, 'static')))
});