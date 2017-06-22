var hello1 = function(text) {
	return text + ' hello!';
};

var hello2 = function(text) {
	return 'hello1 > ' + hello1(text) + '\nhello2 > ' + text;
};