/**
 * 
 */
 
 function summernoteInit(selector, code) {
		
	$("#"+selector).summernote({
		height: 400,
		callbacks: {
			onImageUpload: function(files) {
				//files : 업로드한 이미지 파일 객체
				let formData = new FormData();
				formData.append("files", files[0]);
				
				// /board/summerFileUpload
				$.ajax({
					type: "POST",
					url: "./summerFileUpload",
					enctype: 'multipart/form-data',
					processData: false,
					contentType: false,
					data: formData,
					success: function(data) {
						$(".note-image-input").val('');
						$("#"+selector).summernote('editor.insertImage', data.trim());
					}
				});
			},
			onMediaDelete: function(files) {
				let fileName = $(files[0]).attr("src");
				console.log(fileName);
				$.ajax({
					type: "GET",
					url: "./summerFileDelete",
					data: {
						fileName: fileName
					},
					success: function(data) {
						console.log(data);
					}
				});
			}
		}
	});
	$("#"+selector).summernote('code', code);
}
 
	