/*apifetch()
function apifetch(){
	var pageNo = document.getElementById("api").innerHTML;;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "https://reqres.in/api/users?page="+pageNo, true);	
	xhr.onload = function(){
    	console.log(xhr.responseText);
	};
	xhr.send();
}*/
var page = document.getElementById("api").innerHTML;
fetch('https://reqres.in/api/users?page='+page)
.then(response => response.json())
.then(json => {
    console.log(json.data);
    const userlist = json.data.map(el => {
        return `
        <li class="card-container">
             <div class="name-container"> 
                 <span class="firstName">${el.first_name}</span>
                 <span class="lastName">${el.last_name}</span>
             </div> 
             <p class="email">${el.email}</p>
             <div class="image-container">
              	<img class="round" src="${el.avatar}">
             </div>
            </li>
        `
    });
    console.log(userlist);
    document.querySelector('.list-container').innerHTML = userlist.join('');
  
})