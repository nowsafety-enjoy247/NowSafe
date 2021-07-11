var mysql = require('mysql');

var connection = mysql.createConnection({
    host:"nowsafedb.cmou0lmvg1nl.ap-northeast-2.rds.amazonaws.com",
    user:"enjoy247",
    database:"nowsafedb",
    password="enjoy247",
    port: 3306
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    con.query(sql , function (err,result){
        if(err) throw err;
        console.log("Result: "+result);
    });
});