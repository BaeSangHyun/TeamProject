package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import data.Database;
import vo.ApplyStatusVO;
import vo.CandidateVO;
import dao.CertificateDao;
import dao.CertificateDaoImpl;
import dao.MypageDao;
import dao.MypageDaoImpl;
import dao.Session;
import vo.ExamCategoryVO;
import vo.MypageVO;


public class CertificateServiceImpl implements CertificateService{

	private static CertificateServiceImpl instance;
	
	private CertificateServiceImpl(){}
	
	public static CertificateServiceImpl getInstance(){
		if(instance == null){
			instance = new CertificateServiceImpl();
		}
		return instance;
	}

	MypageService myPageService = MypageServiceImpl.getInstance();
	MypageDao mypageDao = MypageDaoImpl.getInstance();
	Scanner s = new Scanner(System.in);
	Database database = Database.getInstance();
	List<ApplyStatusVO> applyList;
	int menu;

	@Override
	public void confirmPass() {
		System.out.println();
		System.out.println("───────────────────────────시험결과보기──────────────────────────");
		System.out.println("\t시험명\t\t\t회차\t\t\t시험유형\t수험번호\t\t시험결과");
		System.out.println("──────────────────────────────────────────────────────────────");

		ApplyStatusVO applyStatusVO = null;
		List<ApplyStatusVO> applyList = mypageDao.viewApplyList(Session.loginUser.getId());
		for(int i=0; i<applyList.size(); i++){
			applyStatusVO = applyList.get(i);

			System.out.println(
					i+1 + ". "+MypageServiceImpl.getInstance().getExamTitle(applyStatusVO.getCategoryNum())
							+ "\t|\t"+applyStatusVO.getTurn()
							+ "\t|\t"+applyStatusVO.getExamType()
							+ "\t|\t"+applyStatusVO.getApplierNum()
							+ "\t|\t"+MypageServiceImpl.getInstance().getPassStatus(applyStatusVO.getId(), applyStatusVO.getCategoryNum(), applyStatusVO.getTurn())

			);
		}
	}

	@Override
	public void getCertificateList() {

		myPageService.viewIssueList(Session.loginUser.getId());

	}

	@Override
	public void issue(int m) {
		List<ApplyStatusVO> applyList = mypageDao.viewApplyList(Session.loginUser.getId());
		ApplyStatusVO applyStatusVO = applyList.get(m-1);
		String candidate = MypageServiceImpl.getInstance().getPassStatus(applyStatusVO.getId(), applyStatusVO.getCategoryNum());
		if(!(applyStatusVO.getExamType().equals("실기") && candidate.equals("합격"))){
			System.out.println("최종합격(실기)가 된 자격증만 발급 가능합니다.");
			return;
		}
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		MypageVO mypageVO = new MypageVO();
		mypageVO.setId(Session.loginUser.getId());
		mypageVO.setTitle(MypageServiceImpl.getInstance().getExamTitle(applyStatusVO.getCategoryNum()));
		mypageVO.setIssueRequestDate(simpleDateFormat.format(date));
		mypageVO.setProgressStatus("발급신청완료");
		database.tb_certificateIssueList.add(mypageVO);
		System.out.println("--------------------------------------------------------");
		System.out.println("발급신청이 완료되었습니다.");
		System.out.println("--------------------------------------------------------");
	}
	
}
