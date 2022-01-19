const section = document.querySelector('#userlistjs');
var pagenum = document.getElementById("num").innerHTML;
console.log(pagenum);

let requestURL = 'https://reqres.in/api/users?page='+pagenum;
let request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'json';
request.send();

request.onload = function() {
const users = request.response;
showUsers(users);
}

function showUsers(obj) {
const users = obj['data'];
for (let i = 0; i < users.length; i++) {
	const myArticle = document.createElement('article');
	const myH2 = document.createElement('p');
	const myPara1 = document.createElement('p');
	const myImage = document.createElement('img');
    myImage.src = users[i].avatar;
	myH2.textContent = users[i].email;
	myPara1.textContent = users[i].first_name+" "+users[i].last_name;
    myH2.textContent = users[i].email;
    myArticle.className+="card-container";
    myArticle.appendChild(myImage);
	myArticle.appendChild(myPara1);
	myArticle.appendChild(myH2);
	section.appendChild(myArticle);
	}
}