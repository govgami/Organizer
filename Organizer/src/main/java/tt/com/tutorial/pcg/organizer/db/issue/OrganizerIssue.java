package tt.com.tutorial.pcg.organizer.db.issue;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="organizer_issues")
@Entity
public class OrganizerIssue  implements Serializable{
	
	private static final long serialVersionUID = -5779250262246228208L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=ISSUE_ID, nullable=false)
	protected Long issueID;
	@Column(name=ISSUE_NAME, nullable=false)
	protected String issueName;
	@Column(name=ISSUE_MEMO)
	protected String issueMemo;
	@Column(name=ISSUE_PRIORITY, nullable=false)
	protected Integer issuePriority;
	
	public static final String ISSUE_ID="id";
	public static final String ISSUE_NAME="name";
	public static final String ISSUE_MEMO="descript";
	public static final String ISSUE_PRIORITY="priority";
	
	protected OrganizerIssue() {}
	public OrganizerIssue(String issueName, String issueMemo, Integer issuePriority) {
		this.issueName=issueName;
		this.issueMemo=issueMemo;
		this.issuePriority=issuePriority;
	}
	
	
	public Long getIssueID() {
		return issueID;
	}

	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	public String getIssueMemo() {
		return issueMemo;
	}
	public void setIssueMemo(String issueMemo) {
		this.issueMemo = issueMemo;
	}
	public Integer getIssuePriority() {
		return issuePriority;
	}
	public void setIssuePriority(Integer issuePriority) {
		this.issuePriority = issuePriority;
	}
	
	

}
