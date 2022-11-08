package day12;

//인터페이스는 기능들을 나열한 것
interface TvRemoteController {
	// 전원 켜기
	// void turnOn();	
	// 전원 끄기
	// void turnOff();	
	// 전원 켜기/끄기
	void turn();
	
	// 채널 변경(숫자)
	void channer(int channel);
	// 채널 업
	void channelUp();
	// 채널다운
	void channelDown();
	// 볼륨 업
	void volumnUp();
	// 볼륨 다운
	void volumnDown();
	
}