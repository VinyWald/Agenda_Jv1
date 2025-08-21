/**
 * Validacao de formulario
 * @author Chuck Norton
 */

function validar() {
	
	let tipo = frmContato.tipo.value
	let mat = frmContato.mat.value
	
	if (tipo === "") {
		alert('Campo "Tipo" necessário')
		frmContato.tipo.focus()
		return false
	} else if (mat ==="") {
		alert('Nome da matéria necessário')
		frmContato.mat.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}