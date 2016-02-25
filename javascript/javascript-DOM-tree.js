/*
	JS for print the DOM structure in console along with alert
	The output of this page is in javascript-DOM-tree-output.txt(sibling file)
*/
var strings = "";
function carryOn(node, depth){
  depth = depth + 1;
  if(typeof node !== "undefined"){
    try{
    strings = strings + "\n" + depth + "%" + node.nodeName;
		if(node.attributes["id"]){
			strings = strings+"#"+node.attributes["id"].nodeValue;
		}
		else if(node.attributes["class"]){
			strings = strings+"."+node.attributes["class"].nodeValue;
		}
    }
    catch(err){
	  console.log(depth);	
      	  console.error(err);
    }
    var childNodes = node.children;
    var childCount = node.childElementCount;
    var loopCounter = 0;
    for (loopCounter = 0; loopCounter < childCount; loopCounter++) { 
      carryOn(childNodes[loopCounter], depth);
    }
  }
}
carryOn(document, 0);
var output = "";
var strArr = strings.split("\n");
for(i = 0;  i< strArr.length ;i++){
    if(strArr[i].length > 1){
		var no_spaces = parseInt(strArr[i].substring(0, strArr[i].indexOf('%')));
		var spaces = "";
		strArr[i] = strArr[i].substring(strArr[i].indexOf('%') + 1);
		for(j = 1 ; j<=no_spaces;j++){
			spaces = spaces + "-->";
		}
		console.log(spaces + strArr[i]);
		output = output + spaces + strArr[i] + "\n"
	}
}
alert(output);
