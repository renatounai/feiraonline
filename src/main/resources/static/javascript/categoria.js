// JQuery

$( document ).ready(function() {
  $('.linkExcluir').click(function(link, evento) {
	  var id = $(this).data("id");
	  var tr = $(this).parent().parent(); 
	  
	  $.ajax({
		    url: '/categorias/' + id,
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
	    url: '/categorias',
	    type: 'POST',
	    data: JSON.stringify(categoria),
	    dataType : 'json',
	    contentType: 'application/json',
	    complete: function(result) {
	    	console.log('cadastrado com sucesso!');
	    	window.location = '/home';
	    }
	});
}

