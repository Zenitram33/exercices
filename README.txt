Packaging:
	Sous Linux: 
		- Ouvrir un shell et se placer à la racine du projet 'exerciseApi'.
		- exécuter la commande './mvnw clean install' afin de générer le fichier jar du projet.
		- Se placer dans le dossier /target et exécuter la commande "java -jar exercise-0.0.1-SNAPSHOT.jar" afin de lancer l'application SpringBoot.

	Sous Windows:
		- Ouvrir un invite de commande et se placer à la racine du projet 'exerciseApi'.
		- exécuter la commande 'mvnw.cmd clean install' afin de générer le fichier jar du projet.
		- Se placer dans le dossier /target et exécuter la commande "java -jar exercise-0.0.1-SNAPSHOT.jar" afin de lancer l'application SpringBoot.


Testing:

Afin de tester facilement l'API, il faut utiliser un outil permettant d'envoyer des requêtes facilement. Pour ma part, j'utilise Postman.
Vous pouvez trouver dans le dossier /utils à la racine du projet un fichier json intitulé "importPostmanRequests.json" qui une fois importé dans Postman,
créera automatiquement les requêtes à effectuer. Il faudra juste les lancer dans l'ordre du scénario.
Vous pouvez également trouver dans ce dossier les différents json utiles aux requêtes si vous utilisez un outil autre que Postman.

Scénario:
Avant de lancer ces requêtes, il faut préalablement avoir effectué la partie Packaging jusqu'à la dernière étape et donc lancer l'application SpringBoot.

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

