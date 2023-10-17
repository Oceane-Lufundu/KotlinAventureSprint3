package generateur

import model.item.Bombe
import java.nio.file.Files
import java.nio.file.Paths

class GenerateurBombes (val cheminFichier: String) {
    /**
     * Génère et retourne un mapping des bombes à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des bombes où la clé est le nom de la bombe en minuscules et la valeur est un objet Bombe.
     */
    fun generer(): MutableMap<String, Bombe> {
        val mapObjets = mutableMapOf<String, Bombe>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()
            val objet = Bombe(nombreDeDes = ligneObjet[1].toInt(), maxDe = ligneObjet[2].toInt(), nom = ligneObjet[0].toString(), description = ligneObjet[3].toString())
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}