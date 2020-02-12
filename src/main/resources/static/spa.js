var baseUrl = "http://localhost:9090"
console.log(baseUrl)
$("#buddyForm").submit(function(e) {
       e.preventDefault(); // avoid to execute the actual submit of the form.
       var form = $(this);
        var url = baseUrl + '/api/buddyinfo';
       $.ajax({
              type: "POST",
              url: url,
              data: form.serialize(), // serializes the form's elements.
              success: function(data)
              {
                 console.log(data) // show response from the php script.
              }
            });
});
$("#bookForm").submit(function(e) {
   e.preventDefault(); // avoid to execute the actual submit of the form.
   var form = $(this);
//   var url = form.attr('action');
   var url = baseUrl + '/api/addressbook';
   $.ajax({
          type: "POST",
          url: url,
          data: form.serialize(), // serializes the form's elements.
          success: function(data)
          {
              console.log(data) // show response from the php script.
          }
   }).done(function(data){
        bookObj = "<li></li>"
        $("#addressBookList").append()
   });
});
