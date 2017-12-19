package tt.com.tutorial.pcg.organizer.db.issue;

import java.util.ArrayList;
import java.util.List;

public class IdVessel {
	protected String checkeds;

	protected IdVessel() {
	}

	public IdVessel(String checked) {
		this.checkeds = checked;
	}

	public List<Long> getList() {
		List<Long> list = new ArrayList<Long>();
		for (String s : checkeds.split(",")) {
			list.add(new Long(s));
		}
		return list;
	}

	public String getCheckeds() {
		return checkeds;
	}

	public void setChecked(String checked) {
		this.checkeds = checked;
	}

}
