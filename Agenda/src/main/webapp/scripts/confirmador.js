/**
 * 
 *//**
* Validação de exclusão de contato
* @author Chuck Norton
@param Idcon
*/

function confirmar(idcon) {
	let resposta = confirm("Confirma a exclusão deste trabalho?")

	if (resposta === true) {
	
		window.location.href = "delete?idcon=" + idcon

		return false

	} 
}