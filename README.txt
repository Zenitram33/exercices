Packaging:
	Sous Linux: 
		- Ouvrir un shell et se placer � la racine du projet 'exerciseApi'.
		- ex�cuter la commande './mvnw clean install' afin de g�n�rer le fichier jar du projet.
		- Se placer dans le dossier /target et ex�cuter la commande "java -jar exercise-0.0.1-SNAPSHOT.jar" afin de lancer l'application SpringBoot.

	Sous Windows:
		- Ouvrir un invite de commande et se placer � la racine du projet 'exerciseApi'.
		- ex�cuter la commande 'mvnw.cmd clean install' afin de g�n�rer le fichier jar du projet.
		- Se placer dans le dossier /target et ex�cuter la commande "java -jar exercise-0.0.1-SNAPSHOT.jar" afin de lancer l'application SpringBoot.


Testing:

Afin de tester facilement l'API, il faut utiliser un outil permettant d'envoyer des requ�tes facilement. Pour ma part, j'utilise Postman.
Vous pouvez trouver dans le dossier /utils � la racine du projet un fichier json intitul� "importPostmanRequests.json" qui une fois import� dans Postman,
cr�era automatiquement les requ�tes � effectuer. Il faudra juste les lancer dans l'ordre du sc�nario.
Vous pouvez �galement trouver dans ce dossier les diff�rents json utiles aux requ�tes si vous utilisez un outil autre que Postman.

Sc�nario:
Avant de lancer ces requ�tes, il faut pr�alablement avoir effectu� la partie Packaging jusqu'� la derni�re �tape et donc lancer l'application SpringBoot.

1) 
Verbe HTTP : POST
URL : http://localhost:8080/api/messages
Body Json : fichier request1.json

2)
Verbe HTTP : POST
URL : http://localhost:8080/api/customer-files
Body Json : fichier request2.json

3)
Verbe HTTP : POST
URL : http://localhost:8080/api/customer-files/2/messages
Body Json : fichier request3.json

4)
Verbe HTTP : PUT
URL : http://localhost:8080/api/customer-files/2
Body Json : fichier request4.json

5)
Verbe HTTP : GET
URL : http://localhost:8080/api/customer-files/

