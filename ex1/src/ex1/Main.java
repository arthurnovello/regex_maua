package ex1;

public class Main {

	public static void main(String[] args) {
		String[] phoneList = {
				"   Evergreen Valley College; 274-7900",
				"Dijsktra, Edsger W.  ; 510-555-0297",
				"Hoare, C. Anthony R.; 312 555-8763   ",
				"Key Point Software; 249-6625",
				"   O'Reilly & Associates; (800)775-7731",
				"Peterson 3rd, Gordon E.; 217-555-1212",
				"Ratchett, Doofus P. ; 408  375 - 27651"
				};
		
		processContact(phoneList);
	
	
	}
	
	public static void processContact(String cont[]){
		System.out.println("Phone\tName");
		System.out.println("-----\t----");
		for(int i = 0; i<cont.length; i++){
			String[] splitado = cont[i].split(";");
			String nome = processName(splitado[0]);
			String phone = processPhone(splitado[1]);
			if(phone != null && nome != null){
				System.out.println(phone+"\t"+nome);
			}
			
		}
		
	}
	
	public static String processName(String nome){
		nome = nome.trim();
		if(nome.matches("^.*[,].*$")){
			String[] nomeSplit = nome.split(",");
			nome = nomeSplit[1].trim() +" "+nomeSplit[0].trim();
		}
		
		return nome;
	}

	public static String processPhone(String phone){
		phone = phone.trim();
		if(phone.matches("^[0-9]{3}[-][0-9]{4}$")){
			phone = "(408) "+phone;
		}else if(phone.matches("^[0-9]{3}[-][0-9]{3}[-][0-9]{4}$")){
			String[] phoneSplit = phone.split("-");
			phone = "("+phoneSplit[0].trim()+") "+phoneSplit[1].trim()+"-"+phoneSplit[2].trim();
		}else if(phone.matches("^[0-9]{3}[ ][0-9]{3}[-][0-9]{4}$")){
			String[] phoneSplit = phone.split(" ");
			phone = "("+phoneSplit[0].trim()+") "+phoneSplit[1].trim();
		}else if(phone.matches("^[(][0-9]{3}[)][0-9]{3}[-][0-9]{4}$")){
			String[] phoneSplit = phone.split("\\)");
			phone = phoneSplit[0].trim()+") "+phoneSplit[1].trim();
		}else{
			phone = null;
		}
		
		return phone;
	}


}
