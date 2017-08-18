var no=1, rowvalue="";
var id_inputitem="";
var priceno, id_inputprice="";
var quantityno, id_inputquantity="";
document.getElementById("frowcount").value = no;

function addrow()
{
	no = no + 1;
	
	document.getElementById("frowcount").value = no;
	
//	item id
	id_inputitem="fitem"+no;
	
//	item attributes
	var item_att_type = document.createAttribute("type");
	var item_att_placeholder = document.createAttribute("placeholder");
	var item_att_id = document.createAttribute("id");
	var item_att_name = document.createAttribute("name");
	
//	item attributes values
	item_att_type.value="text";
	item_att_placeholder.value="Enter item";
	item_att_id.value=id_inputitem;
	item_att_name.value=id_inputitem;
	
//	item input element
	var inputitem = document.createElement("input");
	inputitem.setAttributeNode(item_att_type);
	inputitem.setAttributeNode(item_att_placeholder);
	inputitem.setAttributeNode(item_att_id);
	inputitem.setAttributeNode(item_att_name);
	
//	price id
	id_inputprice="fprice"+no;	
	
//	price attributes
	var price_att_type = document.createAttribute("type");
	var price_att_placeholder = document.createAttribute("placeholder");
	var price_att_id = document.createAttribute("id");
	var price_att_name = document.createAttribute("name");
	
//	price attributes values
	price_att_type.value="number";
	price_att_placeholder.value="Enter price";
	price_att_id.value=id_inputprice;
	price_att_name.value=id_inputprice;
	
//	price input element
	var inputprice = document.createElement("input");
	inputprice.setAttributeNode(price_att_type);
	inputprice.setAttributeNode(price_att_placeholder);
	inputprice.setAttributeNode(price_att_id);
	inputprice.setAttributeNode(price_att_name);
	
//	quantity id
	id_inputquantity="fquantity"+no;	
	
//	quantity attributes
	var quantity_att_type = document.createAttribute("type");
	var quantity_att_placeholder = document.createAttribute("placeholder");
	var quantity_att_id = document.createAttribute("id");
	var quantity_att_name = document.createAttribute("name");
	
//	quantity attributes values
	quantity_att_type.value="number";
	quantity_att_placeholder.value="Enter quantity";
	quantity_att_id.value=id_inputquantity;
	quantity_att_name.value=id_inputquantity;
	
//	quantity input element
	var inputquantity = document.createElement("input");
	inputquantity.setAttributeNode(quantity_att_type);
	inputquantity.setAttributeNode(quantity_att_placeholder);
	inputquantity.setAttributeNode(quantity_att_id);
	inputquantity.setAttributeNode(quantity_att_name);
	
//	td item element
	var tditem = document.createElement("td");
	tditem.appendChild(inputitem);
	
//	td price element
	var tdprice = document.createElement("td");
	tdprice.appendChild(inputprice);
	
//	td quantity element
	var tdquantity = document.createElement("td");
	tdquantity.appendChild(inputquantity);
	
//	tr element
	var tr = document.createElement("tr");
	tr.appendChild(tditem);
	tr.appendChild(tdprice);
	tr.appendChild(tdquantity);

//	var emptyrow = document.getElementById("emptyrow");
//	var emptyrow = document.getElementById("ftable").lastChild;
	
	var parent_table = document.getElementById("ftable");
//	parent_table.insertBefore(tr, emptyrow);
	parent_table.append(tr);
}