package tt.com.tutorial.pcg.organizer.db.issue;

import java.io.Serializable;

public class OrganizerIssueId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -688287815826216259L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected OrganizerIssueId() {
	}

	public OrganizerIssueId(long idValue) {
		this.id = idValue;
	}
}
