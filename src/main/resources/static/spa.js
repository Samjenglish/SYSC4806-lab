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
        })
       .done(function(data){
           $("#buddyForm").trigger("reset")
           addressItemId = "#item_" + data.id
           $(addressItemId).replaceWith(createAddressBookHTML(data))
       });
});
$("#bookForm").submit(function(e) {
   e.preventDefault(); // avoid to execute the actual submit of the form.
   var form = $(this);
   var url = baseUrl + '/api/addressbook';
   $.ajax({
          type: "POST",
          url: url,
          data: form.serialize(), // serializes the form's elements.
          success: function(data)
          {
              console.log("success") // show response from the php script.
          }
   }).done(function(data){
        $("#bookForm").trigger("reset")
        $("#addressBookList").append(createAddressBookHTML(data))
        $("#bookRadioButtons").append(createAddressBookOption(data))
   });
});

function createAddressBookHTML(abObj){
    idName = "item_" + abObj.id
    listString = ""
    for(var i = 0; i < abObj.buddyList.length; i++){
        listString += "<li>" +"<p>Buddy# " + i + "</p>" +"<p>Name: " + abObj.buddyList[i].name + " - Phone Number: " + abObj.buddyList[i].phoneNumber + "</p>" + "</li>"
    }
    obj =
    "<li id='" + idName + "'><h2>" + abObj.bookName + "</h2>" + "<ul>" + listString + "</ul></li>"
    return obj
}

function createAddressBookOption(abObj){
    obj= "<label>" + abObj.bookName + "<input  type='radio' value='" + abObj.id + "'name='bookId'><br></label>"
    return obj
}
