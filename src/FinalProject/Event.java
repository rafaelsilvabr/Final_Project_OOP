package FinalProject;

public class Event {
	private String name;
	private int start_month,start_year;
	private int end_month,end_year;
	private String institutionName;
	private int type; //  0 = National | 1 = International

	public Event(String name, int start_month, int start_year, int end_month, int end_year, String institutionName,
			int type) {
		this.name = name;
		this.start_month = start_month;
		this.start_year = start_year;
		this.end_month = end_month;
		this.end_year = end_year;
		this.institutionName = institutionName;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart_month() {
		return start_month;
	}

	public void setStart_month(int start_month) {
		this.start_month = start_month;
	}

	public int getStart_year() {
		return start_year;
	}

	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}

	public int getEnd_month() {
		return end_month;
	}

	public void setEnd_month(int end_month) {
		this.end_month = end_month;
	}

	public int getEnd_year() {
		return end_year;
	}

	public void setEnd_year(int end_year) {
		this.end_year = end_year;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}

