var mysql = require('mysql');
var express = require('express');
var bodyParser= require('body-parser');
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.listen(3000, 'localhost', function () {
    console.log('서버 실행 중...');
});

var connection = mysql.createConnection({
    host:"nowsafedb.cmou0lmvg1nl.ap-northeast-2.rds.amazonaws.com",
    user:"enjoy247",
    database:"nowsafedb",
    password:"ensharp123",
    port: 3306
});


//회원가입
app.post('/user/join',function (req,res){
    var id = req.body.id;
    var password = req.body.password;
    var name = req.body.name;
    var position = req.body.postion;

    // 삽입을 수행하는 sql문.
    var sql = 'INSERT INTO users (id, name, password,positon) VALUES (?, ?, ?, ?)';
    var params = [id, name, password, position];
    
    // sql 문의 ?는 두번째 매개변수로 넘겨진 params의 값으로 치환된다.

    connection.query(sql,params,function(err,result){
        var resultCode =404;
        var message ='에러가 발생했습니다.';

        if (err){
            console.log(err);
        }else{
            resultCode=200;
            message='회원가입에 성공했습니다.';
        }

        res.json({
            'code':resultCode,
            'message':message
        });
    });

});


//로그인
app.post('/user/login', function (req, res) {
    var id = req.body.id;
    var password = req.body.password;
    var sql = 'select * from users where id = ?';

    connection.query(sql, id, function (err, result) {
        var resultCode = 404;
        var message = '에러가 발생했습니다';

        if (err) {
            console.log(err);
        } else {
            if (result.length === 0) {
                resultCode = 204;
                message = '존재하지 않는 계정입니다!';
            } else if (userPwd !== result[0].UserPwd) {
                resultCode = 204;
                message = '비밀번호가 틀렸습니다!';
            } else {
                resultCode = 200;
                message = '로그인 성공! ' + result[0].UserName + '님 환영합니다!';
            }
        }

        res.json({
            'code': resultCode,
            'message': message
        });
    })
});
