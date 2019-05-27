package dao;

import java.util.ArrayList;

import vo.AnswerSheetVO;
import vo.CandidateVO;
import data.Database;

public class AnnounceDaoImpl implements AnnounceDao {

	private static AnnounceDaoImpl instance;

	private AnnounceDaoImpl() {
	}

	public static AnnounceDaoImpl getInstance() {
		if (instance == null) {
			instance = new AnnounceDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();

	@Override
	public ArrayList<CandidateVO> passAnnounce() {

		return database.tb_candidate;

	}

	@Override
	public ArrayList<AnswerSheetVO> answerAnnounce() {

		return database.answer;

	}

	@Override
	public void insert(AnswerSheetVO answer) {
		database.answer.add(answer);
		
	}

}
