function removeUser(staff_id) {
	var txt;
	var password = prompt("Please enter your password to Delete " + staff_id +":", "Password Here");
//	$.redirect('/', {'arg1': 'value1', 'arg2': 'value2'});
	if (password) {
		//check is password is correct
		window.location.href = "staff/delete?staff_id=" + staff_id+"&password="+password
	}	
}
function removeInventory(inventory_id) {
	var txt;
	var password = prompt("Please enter your password to Delete " + inventory_id +":", "Password Here");
//	$.redirect('/', {'arg1': 'value1', 'arg2': 'value2'});
	if (password) {
		//check is password is correct
		window.location.href = "inventory/delete?inventory_id=" + inventory_id+"&pass="+password
	}	
}
function removeStudent(mis) {
	var txt;
	var password = prompt("Please enter your password to Delete " + mis +":", "Password Here");
//	$.redirect('/', {'arg1': 'value1', 'arg2': 'value2'});
	if (password) {
		//check is password is correct
		window.location.href = "student/delete?mis=" + mis +"&pass="+password
	}	
}

function removeMenu(name) {
	var txt;
	var password = prompt("Please enter your password to Delete" + name +":", "Password Here");
//	$.redirect('/', {'arg1': 'value1', 'arg2': 'value2'});
	if (password) {
		//check is password is correct
		window.location.href = "menu/delete?name=" + name
	}	
}
/*$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	var actions = $("table td:last-child").html();
	// Append table with add row form on add new button click
    $(".add-new").click(function(){
		$(this).attr("disabled", "disabled");
		var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td>ID</td>' +
            '<td><input type="text" class="form-control" name="name" id="department"></td>' +
            '<td><input type="text" class="form-control" name="account_no" id="phone"></td>' +
            '<td><input type="text" class="form-control" name="contact="phone"></td>' +
			'<td><input type="text" class="form-control" name="address" id="phone"></td>' +
			'<td>' + actions + '</td>' +
        '</tr>';
    	$("table").append(row);		
		$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	// Add row on add button click
	$(document).on("click", ".add", function(){
		var empty = false;
		var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function(){
			if(!$(this).val()){
				$(this).addClass("error");
				empty = true;
			} else{
                $(this).removeClass("error");
            }
		});
		$(this).parents("tr").find(".error").first().focus();
		if(!empty){
			input.each(function(){
				$(this).parent("td").html($(this).val());
			});			
			$(this).parents("tr").find(".add, .edit").toggle();
			$(".add-new").removeAttr("disabled");
		}		
    });
	// Edit row on edit button click
	$(document).on("click", ".edit", function(){		
        $(this).parents("tr").find("td:not(:last-child)").each(function(){
			$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
		});		
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").attr("disabled", "disabled");
    });
	// Delete row on delete button click
	$(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });
});
*/