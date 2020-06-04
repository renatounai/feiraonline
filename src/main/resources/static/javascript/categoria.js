// JQuery

$( document ).ready(function() {
  $('.linkExcluir').click(function(link, evento) {
	  var id = $(this).data("id");
	  var tr = $(this).parent().parent(); 
	  
	  $.ajax({
		    url: '/api/categorias/' + id,
		    type: 'DELETE',
		    success: function(result) {
		    	tr.remove(); 
		    }
		});
  });
});

function salvarCategoria() {
	var categoria = {
		id : $('#id').val(),
		"nome" : $('#nome').val()
	};
	
	$.ajax({
	    url: '/api/categorias',
	    type: 'POST',
	    data: JSON.stringify(categoria),
	    dataType : 'json',
	    contentType: 'application/json',
	    complete: function(result) {	    	
	    	window.location = '/categorias';
	    }
	});
}

