# auth-rest-api
Practicing a simple auth rest api use spring boot

Try it in posman or insomnia.
1. List of User
GET http://localhost:8080/api/v1/auth

2. Search User by Id
GET http://localhost:8080/api/v1/auth/{id}
keterangan: {id} diganti angka dari id user

3. Register New User
POST http://localhost:8080/api/v1/auth
	Content-Type : application/json

	{
		username : "blablabla",
		password : "blablabla"
	}

4. Update User
PUT http://localhost:8080/api/v1/auth
	Content-Type : application/json

	{
		id : {id}
		username : "blablabla",
		password : "blablabla"
	}
keterangan: {id} diganti angka dari id user yg ingin diupdate

5. Login
POST http://localhost:8080/api/v1/auth/login
	Content-Type : application/json

	{
		username : "blablabla",
		password : "blablabla"
	}
keterangan: user dan password liat di hasil nomor 1. List of User

6. Delete User
DELETE http://localhost:8080/api/v1/auth/{id}
keterangan: {id} diganti angka dari id user yg ingin dihapus
