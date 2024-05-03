// register Form

$(function() {
	var button = $('#reviewButton');
	var box = $('#reviewBox');
	var form = $('#reviewForm');
	button.removeAttr('href');
	button.mouseup(function(review) {
		box.toggle();
		button.toggleClass('active');
	});
	form.mouseup(function() {
		return false;
	});
	$(this).mouseup(function(review) {
		if (!($(review.target).parent('#reviewButton').length > 0)) {
			button.removeClass('active');
			box.hide();
		}
	});
});