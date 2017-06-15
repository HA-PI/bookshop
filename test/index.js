/**
 * Created by moyu on 2017/6/15.
 */

var assert = require('assert');

describe('Array', function () {
    describe('#indexOf()', function () {
        it('should return -1 when the value is not present', function () {
            assert.equal(-1, [1, 2, 3].indexOf(4));
        });
    });
});


const path = require('path')
const request = require('supertest')
require('should')

const doc = require('test2doc')

doc.title('BookShop Web API')
    .version('1.0.0')
    .desc('BookShop Web API 接口说明，自动生成，来自test2doc.')
    .scheme('http')
    .host('www.moyuyc.xyz:8080')
    .basePath('/api')

after(function () {
    doc.emit(path.join(__dirname, 'gen/api.apib'), 'apib')
    doc.emit(path.join(__dirname, 'gen/api.yml'), 'swagger')
});

const base = 'http://localhost:8080'

describe('User', function () {
    doc.group('User').basePath('/user/register').desc('用户注册接口').is(doc => {
        it('should provide /api/user/register', async function () {
            await doc.action('用户注册').desc('用户注册').is(async doc => {
                const res = await request(base)
                    .post(doc.post('/api/user/register'))
                    .query(doc.query({username: doc.val('moyuyc', '用户名').required(), password: doc.val('moyuyc', '密码').required()}))
                    .expect(doc.status(200))
                    .accept('json')
                // const headers = doc.resHeaders(res.headers);

                const body = doc.resBody(res.body)
                body.code.desc('状态').required().should.be.oneOf(200, 400);
                body.data.desc('提示信息').required().should.be.a.String();
            })
        })

        it('should provide /api/user/login', async function () {
            await doc.action('用户登录').desc('用户登录').is(async doc => {
                const res = await request(base)
                    .get(doc.get('/api/user/login'))
                    .query(doc.query({username: doc.val('moyuyc', '用户名').required(), password: doc.val('moyuyc', '密码').required()}))
                    .expect(doc.status(200))
                const body = doc.resBody(res.body)
                body.code.desc('状态').required().should.be.oneOf(200, 400);
                body.data.desc('提示信息').required().should.be.a.String();
            })
        })

        it('should provide /api/user/logout', async function () {
            await doc.action('用户登出').desc('用户登出').is(async doc => {
                const res = await request(base)
                    .get(doc.get('/api/user/logout'))
                    .query()
                    .type('json')
                    .accept('json')
                    .expect(doc.status(200))

                const body = doc.resBody(res.body)
                body.code.desc('状态').required().should.be.oneOf(200, 400);
                body.data.desc('提示信息').required().should.be.a.String();
            })
        })
    })
})

