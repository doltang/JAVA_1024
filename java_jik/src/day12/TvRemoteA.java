package day12;

public class TvRemoteA implements TvRemoteController {
	
	private int channel;
	private int volumn;
	private boolean power;

	@Override
	public void turn() {
		// power가 켜져있으면 꺼야하고, 꺼져있으면 켜야함
		power = !power;
	
	}

	@Override
	public void channer(int channel) {
		// 전원이 켜져있지 않으면 메소드를 종료하는 코드
		if(!power) {
			return;
		}
		this.channel = channel;
		System.out.println("채널 : " + channel);

	}

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
		channel++;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		channel--;
		channel = channel < 1 ?  999 : channel; // 1번보다 감소시키면 999번으로 넘어감
		System.out.println("채널 : " + channel);
	}

	@Override
	public void volumnUp() {
		if(!power) {
			return;
		}
		volumn++;
		volumn = volumn > 30 ? 30 : volumn;
		System.out.println("볼륨 : " + volumn);
	}

	@Override
	public void volumnDown() {
		if(!power) {
			return;
		}
		volumn--;
		volumn = volumn < 0 ? 0 : volumn;
		System.out.println("볼륨 : " + volumn);
	}
	// 상태 출력
	public void print() {
		System.out.println("전원 : " + (power ? "on" : "off"));
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volumn);
	}

}
