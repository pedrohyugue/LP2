#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int w, h;
    int ai, af;
} Arc;

void Arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) e angulatura(%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y,this->ai,this->af);
}

Arc* arc_new (int x, int y, int w, int h,int ai,int af) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Arc_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->ai = ai;
    this->af = af;
}
////////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int x2, y2;
} Line;

void Line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Line de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->x2, this->y2, sup->x, sup->y);
}

Line* line_new (int x, int y, int x2, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}
////////////////////////////////////////////////////////////////////////////////

void main (void) {
	int i;
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) arc_new(10,10,100,100,30,50),
        (Figure*) line_new(210,110,305,130)
    };

    ///

    for ( i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for ( i=0; i<4; i++) {
        free(figs[i]);
    }
}

