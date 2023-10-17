package generateur

import model.item.Armure
import model.item.TypeArmure
import qualites
import typeArmure
import java.nio.file.Files
import java.nio.file.Paths

/**
 * La classe GenerateurQualites permet de générer des objets de type Armure à partir d'un fichier CSV.
 *
 * @param cheminFichier Le chemin vers le fichier CSV contenant les données des Armure.
 */
class GenerateurArmure(val cheminFichier: String) {
    /**
     * Génère et retourne un mapping des Armure à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des Armure où la clé est le nom de l'armure en minuscules et la valeur est un Armure.
     */
    fun generer(): MutableMap<String, Armure> {
        val mapObjets = mutableMapOf<String, Armure>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()
            val leType= typeArmure[ligneObjet[2]]!!
            val laQualite=qualites[ligneObjet[3]]!!
            val objet = Armure (nom = ligneObjet[0], description = ligneObjet[1], qualite = laQualite, typeArmure = leType)
            mapObjets[cle] = objet
        }
        return mapObjets
    }

}