var express = require('express'),
jsonBody = require("body/json"),
mongoose = require('mongoose'),
app = express();

mongoose.connect('mongodb://localhost:27017/demos');
var Book = mongoose.model('books',new mongoose.Schema({
	number: String,
	title: String,
	author: String
}));

var Food = mongoose.model('foods',new mongoose.Schema({
	name: String,
	desc: String
}));

var User = mongoose.model('users',new mongoose.Schema({
	role: String,
	name: String
}));

var Cat = mongoose.model('cats',new mongoose.Schema({
	name: String,
	desc: String
}));

app.use(express.static("public"));

app.get('/books',function (req, res) {
	Book.find(function (err, data) {
		res.send(data);
	})
});

app.post('/books',function (req, res) {
	jsonBody(req,res,function (err, body) {
		var book = new Book(body);
		book.save(function(){
			res.send(body);
		});
	})
});

app.put('/books/:id',function (req, res) {
	jsonBody(req,res,function (err, body) {
		Book.update({_id: body._id}, body ,function () {
			res.send({result: "ok"});
		});
	})
});
app.delete('/books/:id',function (req, res) {
	var id = req.params.id;
	jsonBody(req,res,function (err, body) {
		Book.remove({_id: id} ,function () {
			res.send({result: "ok"});
		});
	})
});

app.get('/foods',function (req, res) {
	Food.find(function (err, data) {
		res.send(data);
	})
});

app.post('/foods',function (req, res) {
	jsonBody(req,res,function (err, body) {
		var food = new Food(body);
		food.save(function(){
			res.send(body);
		});
	})
});

app.put('/foods/:id',function (req, res) {
	jsonBody(req,res,function (err, body) {
		Food.update({_id: body._id}, body ,function () {
			res.send({result: "ok"});
		});
	})
});
app.delete('/foods/:id',function (req, res) {
	var id = req.params.id;
	jsonBody(req,res,function (err, body) {
		Food.remove({_id: id} ,function () {
			res.send({result: "ok"});
		});
	})
});

app.get('/users/:id',function (req, res) {
	User.findOne({role:"admin"}, function (err, data) {
		console.log(arguments);
		res.send(data);
	})
});
app.put('/users/:id',function (req, res) {
	jsonBody(req,res,function (err, body) {
		User.update({_id: body._id}, body ,function () {
			res.send({result: "ok"});
		});
	})
});

app.get('/cats',function (req, res) {
	Cat.find(function (err, data) {
		res.send(data);
	})
});

app.listen(9432);
console.log('localhost:9432 running ...');