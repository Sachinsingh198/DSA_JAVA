package BitManipulation;

public class ToggleKthBit {
    static int toggleKthBit(int n, int k){
        return n ^ (1 << k);
    }
}
