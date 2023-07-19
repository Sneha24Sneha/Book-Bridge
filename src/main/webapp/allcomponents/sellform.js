/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var categoriesSelect = document.getElementById('categories');
var subcategoriesSelect = document.getElementById('subcategories');

// Populate the categories select element
categoriesSelect.innerHTML = '<option value="">Select Category</option>' +
                           '<option value="school">School Books</option>' +
                           '<option value="Academic Books">Academic Books</option>' +
                           '<option value="Competitive">Competitive Exams Books</option>'+
                            '<option value="Magazines">Magazines</option>';

function updateSubcategories() {
  // Get the selected category
  var selectedCategory = categoriesSelect.value;

  // Clear the subcategories select element
  subcategoriesSelect.innerHTML = '<option value="">Select Subcategory</option>';

  // Populate the subcategories based on the selected category
  switch (selectedCategory) {
    case 'school':
      subcategoriesSelect.innerHTML += '<option value="1-10">Classes 1-10</option>' +
                                     '<option value="11-12">Classes 11-12</option>' ;
                                     
      break;
    case 'Academic Books':
      subcategoriesSelect.innerHTML += '<option value="Engineering">Engineering</option>' +
                                     '<option value="Medical">Medical</option>' +
                                     '<option value="Other College Books">Other College Books</option>';
      break;
    case 'Competitive':
      subcategoriesSelect.innerHTML += '<option value="CAT/GATE/NETS/GRE Books">CAT/GATE/NETS/GRE Books</option>' +
                                     '<option value="AIIMS/NEET Books">AIIMS/NEET Books</option>' +
                                     '<option value="UPSC">UPSC</option>' +
                                     '<option value="PSC">PSC</option>' +
                                     '<option value="SSC/Railway/Bank">SSC/Railway/Bank</option>';
      break;
      case 'Magazines':
      subcategoriesSelect.innerHTML += '<option value="Magazines">Magazines</option>' +
                                     '<option value="Novels">Novels</option>' +
                                     '<option value="History Books">History Books</option>' ;
                                    
      break;
    // Add more cases for other categories as needed
  }
}
 

