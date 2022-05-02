/**
 * 글 작성 시 첨부파일 관리
 */
 
let count=0;
 
function fileDeleteInit() {
	$(".del").click(function () {
		let check = window.confirm("영구히 삭제됩니다. 삭제하시겠습니가?")
		
		if(!check) {
			return;
		}
		
		let fileNum=$(this).attr("data-num");
		console.log(this);
		let selector = $(this);
		$.ajax({
			type:"POST",
			url: "./fileDelete",
			data: {
				fileNum: fileNum
			},
			success: function (data) {
				if(data.trim()=='1') {
					$(selector).parent().remove();
					count--;
				}else {
					alert("삭제 실패!");
				}
			},
			error: function() {
				alert("파일 삭제 실패");
			}
		});
	});
}
 
 
function fileAddInit(c) {
	
	count=c;
	
	$("#fileAdd").click(function() {
		if(count >= 5) {
			alert("파일은 5개까지만");
			return;
		}
		let result = '<div class="input-group">';
		result = result + '<input type="file" class="form-control files" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name="files">';
		result = result + '<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>';
		result = result + '</div>'
		
		$("#fileResult").append(result);
		count++;
	});
	
	$("#fileResult").on("click", ".del", function() {
		$(this).parent().remove();
		count--;
	});
	
};
 