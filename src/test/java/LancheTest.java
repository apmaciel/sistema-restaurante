import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LancheTest {
    @Test
    void precoNegativoERecusado() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Teste", -5.0);
        });
    }

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.0, lanche.getPreco(), 0.001);
    }
}
