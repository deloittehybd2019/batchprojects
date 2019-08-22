package org.del.entities;



public class Customer {
   private String id;
   private String pass;
   private String name;
   private String country;

    public Customer(String id,String pass, String name,String country ) {
        this.id = id;
        this.name = name;
        this.pass=pass;
        this.country=country;
    }


   

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}




	int generatedId;

    public String generateId() {
        generatedId++;
        //
        //using String's valueeOf method to convert to string
        //
        String idStr = String.valueOf(generatedId);
        return idStr;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        int hashCode = id.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;
        return customer.id == this.id;
    }
}
