var test1 = function(data) {
	return 'data > ' + data;
};

var test2 = function(data) {
	// string to json
//	if (typeof data === 'string') {
//		data = JSON.parse(data);
//	}
	var result = '';
	for (var name in data) {
		var value = data[name];
		result += name + ' : ' + value + '\n';
	}
	return result;
};