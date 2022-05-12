/**
 * cart
 */
 
 $("#cart").click(function() {
	let productNum = $(this).attr("data-pn");
	let count = 2;
	$.ajax({
		type:"POST",
		url:"../cart/"+productNum+"/"+count,
		success:function(data) {
			if(data>0) {	
				console.log("data : "+data);			
				let check = confirm("장바구니로 이동하시겠습니까?");
			}else {
				alert("등록 실패");
			}
			
		}
	});
});
 
 $("#btn").click(function() {
	$.ajax({
		type:"DELETE",
		url:"../cart/1",
		success:function(data) {
			console.log(data.trim());
		}	
	});
});
 
function getList() {
	 $.ajax({
		type:"GET",
		url: "../cart/1",
		success:function(data) {
			console.log(data);
			console.log(data[0].cartNum);
		}
		
	
	});	
		
};
