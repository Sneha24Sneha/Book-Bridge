/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



  // Get references to the different sections of the page
  const formSection = document.querySelector('.form-box');
  const searchResultsSection = document.querySelector('#search-results');
  const allProductsSection = document.querySelector('#all-products');

  // Hide the search results and show the all products section by default
  searchResultsSection.style.display = 'none';
  allProductsSection.style.display = 'block';

  // Add a click event listener to the search button
  const searchBtn = document.querySelector('.search-btn');
  searchBtn.addEventListener('click', () => {
    // Get the user's search query
    const searchTerm = document.querySelector('.business').value.trim();

    // If the search query is not empty, show the search results section and hide the all products section
    if (searchTerm) {
      formSection.style.display = 'none';
      searchResultsSection.style.display = 'block';
      allProductsSection.style.display = 'none';
    } else {
      // If the search query is empty, show the all products section and hide the search results section
      formSection.style.display = 'block';
      searchResultsSection.style.display = 'none';
      allProductsSection.style.display = 'block';
    }
  });

