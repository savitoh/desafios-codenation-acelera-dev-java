package challenge;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer episode;

	@Column
	private String episodeName;

	@Column
	private String segment;

	@Column
	private String type;

	@Column
	private String actor;

	@Column
	private String character;

	@Column
	private String detail;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime recordDate;

	@Column
	private String series;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime transmissionDate;

	public Quote() {
	}

	public Quote(Integer episode, String episodeName, String segment, String type, String actor, String character,
				 String detail, LocalDateTime recordDate, String series, LocalDateTime transmissionDate) {
		this.episode = episode;
		this.episodeName = episodeName;
		this.segment = segment;
		this.type = type;
		this.actor = actor;
		this.character = character;
		this.detail = detail;
		this.recordDate = recordDate;
		this.series = series;
		this.transmissionDate = transmissionDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setQuote(String quote) {
		detail = quote;
	}

	public String getQuote() {
		return detail;
	}
}
