/**
 * 
 */

function download(fileName) {
	document.getElementsByName('file')[0].value = fileName;
	document.forms[0].submit();
}