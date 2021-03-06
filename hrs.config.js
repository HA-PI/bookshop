/**
 * Created by moyu on 2017/6/10.
 */

const path = require('path');

module.exports = {
  proxy: {
    "/api": {
      redirect: true, // default: true
      target: "http://172.22.119.251:8080/api",//"http://localhost:6999",
      changeHost: true,  // default: true
      headers: {
        // 'cookie': 'JSESSIONID=C159C79AC054C005A7C1107FBFB3CF61'
      },
      hot: false, // hot reload enable? default: false
      // Function/RegExp: will be set root config hotRule if it is null
      hotRule: function (filename, request) {
        if (request.url === '/') {
          request.url = '/index.jsp';
          filename = path.join(filename, 'index.jsp');
        }
        return /\.(php|jsp)$/.test(filename);
      },
      // Function: return local file path
      mapLocal: function (request) {
        // request: Express Request Object
        // console.log('mapLocal', request.originalUrl, request.baseUrl, request.url);
        if (request.url === '/') {
          request.url = '/index.jsp';
        }
        const url = request.url.replace(/\?[\s\S]*/, '')
        return path.join('/Users/moyu/tomcat 7.0/', "webapps/bookshop", url);
      },
      // Function/String: return detected directory path
      mapRoot: function (request) {
        // request: Express Request Object
        return path.join('/Users/moyu/tomcat 7.0/', "webapps/bookshop");
      }
    },
    "/": {
      redirect: true, // default: true
      target: "http://localhost:8080/",//"http://localhost:6999",
      changeHost: true,  // default: true
      headers: {
        // 'cookie': 'JSESSIONID=C159C79AC054C005A7C1107FBFB3CF61'
      },
      hot: false, // hot reload enable? default: false
    },

  },

  // RegExp or function (filename) {...}
  hotRule: /\.(html|htm)$/, // default: /\.(html|htm)$/

  setUp: function (app) {
    /* app is an express server object. */

    // http://localhost:8082/test
    // app.get('/test', function (req, res) {
    //     res.end("TEST!");
    // });
  }
};
