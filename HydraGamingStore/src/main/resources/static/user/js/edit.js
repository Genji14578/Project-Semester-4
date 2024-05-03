// edit Form

$(function() {
    var button = $('#editButton');
    var box = $('#editBox');
    var form = $('#editForm');
    button.removeAttr('href');
    button.mouseup(function(edit) {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() { 
        return false;
    });
    $(this).mouseup(function(edit) {
        if(!($(edit.target).parent('#editButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
});