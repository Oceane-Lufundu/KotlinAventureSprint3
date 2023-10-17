package generateur
import model.item.Qualite
import model.item.TypeArme
import java.nio.file.Files
import java.nio.file.Paths
/**
 * La classe GenerateurTypeArme permet de générer des objets de type TypeArme à partir d'un fichier CSV.
 *
 * @param cheminFichier Le chemin vers le fichier CSV contenant les données des types d'armes.
 */
class GenerateurTypeArme(val cheminFichier: String)  {
    /**
     * Génère et retourne un mapping des types d'armes à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des types d'armes où la clé est le nom du type d'arme en minuscule et la valeur est un objet TypeArme.
     */
    fun generer(): MutableMap<String, TypeArme> {
        val mapObjets = mutableMapOf<String, TypeArme>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[4].lowercase()
            val objet = TypeArme(nombreDes = ligneObjet[0].toInt(), valeurDeMax = ligneObjet[1].toInt(), multiplicateurCritique = ligneObjet[2].toInt(), activationCritique = ligneObjet[3].toInt(), nom = ligneObjet[4])
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}