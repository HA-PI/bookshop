/**
 * Created by moyu on 2017/6/9.
 */

require('babel-polyfill');
const $ = global.jQuery = global.$ = require('jquery');
require('bootstrap');
const {alert, confirm} = require('dialog')

$(global.document).ready(function () {
    $('#logout-btn').on('click', function (e) {

        confirm("确定退出吗？", () => {
            $(this).prop('disabled', true);
            $.get("/api/user/logout", {}, ({code, data}) => {
                const callback = () => {
                    global.location.reload();
                };
                if (code === 200) {
                    alert(data, callback, callback);
                } else {
                    alert(data);
                }
                $(this).prop('disabled', false);
            }, 'json');
        });

    });
})
