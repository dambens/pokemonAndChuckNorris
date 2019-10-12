package pl.com.sda.pokemonAndChuckNorris.pokemon;

import java.util.List;

public class PokemonDTO {
    private String name;
    private int height;
    private int weight;
    private List<PokemonMoveDTO> moves;
 //   private Sprites front_default;



    public PokemonDTO(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;

    }

    public PokemonDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonMoveDTO> getMoves() {
        return moves;
    }

    public void setMoves(List<PokemonMoveDTO> moves) {
        this.moves = moves;

    }
/*    public Sprites getFront_default() {
        return front_default;
    }

    public void setFront_default(Sprites front_default) {
        this.front_default = front_default;
    }*/
}
