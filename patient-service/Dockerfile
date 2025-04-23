# Utiliser l'image de base Node.js version 18
FROM node:18

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers package.json et package-lock.json dans le conteneur
COPY package*.json ./

# Installer les dépendances définies dans package.json
RUN npm install


# Copier tous les fichiers du projet dans le conteneur
COPY . .

# Exposer le port 3001 pour accéder au service
EXPOSE 3001

# Démarrer l'application Node.js avec la commande `node server.js`
CMD ["node", "server.js"]
