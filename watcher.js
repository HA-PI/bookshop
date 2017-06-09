#!/usr/bin/env node

const fs = require('fs');
const path = require('path');
const cp = require('child_process');

const src_path = path.join(__dirname, 'src');
const web_path = path.join(__dirname, 'web');

fs.watch(src_path, {recursive: true}, function (eventType, filename) {
    console.log(eventType, '->', filename);
    if (filename.endsWith('.java')) {
        console.log(cp.execSync("sh deploy.sh java src/"+filename).toString());
    }
});

fs.watch(web_path, {recursive: true}, function (eventType, filename) {
    console.log(eventType, '->', filename);
    if (filename.endsWith('.jsp') || filename.endsWith('.html') || filename.endsWith('.jar')
        || filename.endsWith('.css') || filename.endsWith('.xml') || filename.endsWith('.js')) {
        console.log(cp.execSync("sh deploy.sh web "+filename).toString());
    }
});