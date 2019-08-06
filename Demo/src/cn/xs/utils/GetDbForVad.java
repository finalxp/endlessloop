package cn.xs.utils;

public class GetDbForVad {
	
	
	public float getRmsdB(float rms) {
		
		//add by me
		float mNoiseLevel = 3; 
		
		if(mNoiseLevel < rms) {
			mNoiseLevel = (0.999f * mNoiseLevel) + (0.001f * rms);
		} else {
			mNoiseLevel = (0.95f * mNoiseLevel) + (0.05f * rms);
		}
		if(((double) mNoiseLevel) <= 0.0d || ((double) (rms / mNoiseLevel)) <= 1.0E-6d) {
			return -120.0f;
		}
		float orignalDb = 10.0f * ((float) Math.log10((double) (rms / mNoiseLevel)));
		//Clamp db to [0, 60]
		return Math.min(Math.max(0.0f, orignalDb), 60.0f);
	}
	
	
	
	public float rms(byte[] buffer, int offset, int length){
		float sum = 0.0f;
		if(length == 0){
			throw new IllegalArgumentException();
		}
		for (int i = offset; i < offset+length; i += 2) {
			short sample = (short)0;
			for (int j = 0; j < 2; j++) {
				sample = (short) (((buffer[i+j] & 255) << (j * 8)) | sample);
				
			}
			sum += (float) (sample * sample);
		}
		
		float fff = (float)Math.sqrt((double) (sum / ((float) (length / 2))));
		return fff;
	}
}
