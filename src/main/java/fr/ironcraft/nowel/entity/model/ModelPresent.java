package fr.ironcraft.nowel.entity.model;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelPresent extends ModelBase
{
	ModelRenderer BaseCadeau;
	ModelRenderer BasCadeauAvant;
	ModelRenderer BasCadeauArriere;
	ModelRenderer BasCadeauGauche;
	ModelRenderer BasCadeauDroit;
	ModelRenderer HautCadeau;
	ModelRenderer HautCadeauG;
	ModelRenderer HautCadeauD;
	ModelRenderer HautCadeauAvant;
	ModelRenderer HautCadeauArriere;
	ModelRenderer Noeud1;
	ModelRenderer Noeud2;
	ModelRenderer RubanH1;
	ModelRenderer RubanH2;
	ModelRenderer RubanH4;
	ModelRenderer RubanH3;
	ModelRenderer RubanTete1;
	ModelRenderer RubanTete2;
	ModelRenderer Ruban1;
	ModelRenderer Ruban2;
	ModelRenderer Ruban3;
	ModelRenderer Ruban4;

	public ModelPresent()
	{
		this(0.0f);
	}

	public ModelPresent(float par1)
	{
		BaseCadeau = new ModelRenderer(this, 55, 3);
		BaseCadeau.setTextureSize(128, 128);
		BaseCadeau.addBox(-9F, -2.5F, -9F, 18, 5, 18);
		BaseCadeau.setRotationPoint(0F, 21.5F, 0F);
		BasCadeauAvant = new ModelRenderer(this, 69, 35);
		BasCadeauAvant.setTextureSize(128, 128);
		BasCadeauAvant.addBox(-7F, -2F, -1F, 14, 4, 2);
		BasCadeauAvant.setRotationPoint(0F, 17F, -8F);
		BasCadeauArriere = new ModelRenderer(this, 68, 27);
		BasCadeauArriere.setTextureSize(128, 128);
		BasCadeauArriere.addBox(-7F, -2F, -1F, 14, 4, 2);
		BasCadeauArriere.setRotationPoint(0F, 17F, 8F);
		BasCadeauGauche = new ModelRenderer(this, 87, 26);
		BasCadeauGauche.setTextureSize(128, 128);
		BasCadeauGauche.addBox(-1F, -2F, -9F, 2, 4, 18);
		BasCadeauGauche.setRotationPoint(-8F, 17F, 0F);
		BasCadeauDroit = new ModelRenderer(this, 87, 50);
		BasCadeauDroit.setTextureSize(128, 128);
		BasCadeauDroit.addBox(-1F, -2F, -9F, 2, 4, 18);
		BasCadeauDroit.setRotationPoint(8F, 17F, 0F);
		HautCadeau = new ModelRenderer(this, 38, 48);
		HautCadeau.setTextureSize(128, 128);
		HautCadeau.addBox(-8F, -7F, -16F, 16, 2, 16);
		HautCadeau.setRotationPoint(0F, 15.5F, 8F);
		HautCadeauG = new ModelRenderer(this, 6, 34);
		HautCadeauG.setTextureSize(128, 128);
		HautCadeauG.addBox(-1F, -3.5F, -10F, 2, 7, 20);
		HautCadeauG.setRotationPoint(-9F, 12F, 0F);
		HautCadeauD = new ModelRenderer(this, 14, 78);
		HautCadeauD.setTextureSize(128, 128);
		HautCadeauD.addBox(-1F, -3.5F, -10F, 2, 7, 20);
		HautCadeauD.setRotationPoint(9F, 12F, 0F);
		HautCadeauAvant = new ModelRenderer(this, 32, 68);
		HautCadeauAvant.setTextureSize(128, 128);
		HautCadeauAvant.addBox(-8F, -3.5F, -1F, 16, 7, 2);
		HautCadeauAvant.setRotationPoint(0F, 12F, -9F);
		HautCadeauArriere = new ModelRenderer(this, 91, 105);
		HautCadeauArriere.setTextureSize(128, 128);
		HautCadeauArriere.addBox(-8F, -3.5F, -1F, 16, 7, 2);
		HautCadeauArriere.setRotationPoint(0F, 12F, 9F);
		Noeud1 = new ModelRenderer(this, 6, 108);
		Noeud1.setTextureSize(128, 128);
		Noeud1.addBox(0F, -8F, 7F, 0, 8, 10);
		Noeud1.setRotationPoint(0F, 8.66872F, -11.53035F);
		Noeud2 = new ModelRenderer(this, 28, 118);
		Noeud2.setTextureSize(128, 128);
		Noeud2.addBox(-5F, -8F, 12F, 10, 8, 0);
		Noeud2.setRotationPoint(0F, 8.668721F, -11.53035F);
		RubanH1 = new ModelRenderer(this, 47, 16);
		RubanH1.setTextureSize(128, 128);
		RubanH1.addBox(-1F, -4.3F, -0.5F, 2, 7, 1);
		RubanH1.setRotationPoint(0F, 12.87831F, -9.777376F);
		RubanH2 = new ModelRenderer(this, 39, 16);
		RubanH2.setTextureSize(128, 128);
		RubanH2.addBox(-1F, -3.78F, -0.5F, 2, 7, 1);
		RubanH2.setRotationPoint(0F, 12.34083F, 10.02694F);
		RubanH4 = new ModelRenderer(this, 32, 15);
		RubanH4.setTextureSize(128, 128);
		RubanH4.addBox(-0.5F, -10.1F, -0.8F, 1, 7, 2);
		RubanH4.setRotationPoint(-10F, 18.65005F, 0.1916168F);
		RubanH3 = new ModelRenderer(this, 37, 5);
		RubanH3.setTextureSize(128, 128);
		RubanH3.addBox(19.5F, -10.1F, -1F, 1, 7, 2);
		RubanH3.setRotationPoint(-10F, 18.65005F, 0.1916158F);
		RubanTete1 = new ModelRenderer(this, 46, 26);
		RubanTete1.setTextureSize(128, 128);
		RubanTete1.addBox(-1F, 1.1F, -0.5F, 2, 21, 1);
		RubanTete1.setRotationPoint(0F, 8.732839F, -11.4552F);
		RubanTete2 = new ModelRenderer(this, 39, 26);
		RubanTete2.setTextureSize(128, 128);
		RubanTete2.addBox(-12.8F, 1.5F, -0.5F, 2, 21, 1);
		RubanTete2.setRotationPoint(-12F, 8.732839F, -11.4552F);
		Ruban1 = new ModelRenderer(this, 65, 2);
		Ruban1.setTextureSize(128, 128);
		Ruban1.addBox(-1F, -4.5F, -0.5F, 2, 9, 1);
		Ruban1.setRotationPoint(0F, 19.6F, -9F);
		Ruban2 = new ModelRenderer(this, 58, 2);
		Ruban2.setTextureSize(128, 128);
		Ruban2.addBox(-1F, -4.5F, -0.5F, 2, 9, 1);
		Ruban2.setRotationPoint(0F, 19.6F, 9F);
		Ruban3 = new ModelRenderer(this, 51, 1);
		Ruban3.setTextureSize(128, 128);
		Ruban3.addBox(-0.5F, -4.5F, -1F, 1, 9, 2);
		Ruban3.setRotationPoint(9F, 19.6F, 0F);
		Ruban4 = new ModelRenderer(this, 44, 1);
		Ruban4.setTextureSize(128, 128);
		Ruban4.addBox(-0.5F, -4.5F, -1F, 1, 9, 2);
		Ruban4.setRotationPoint(-9F, 19.6F, 0F);
	}

	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		render(par7);
	}
	
	public void render()
	{
		render(0.0625f);
	}
	
	public void render(float par7)
	{
		BaseCadeau.rotateAngleX = 0F;
		BaseCadeau.rotateAngleY = 0F;
		BaseCadeau.rotateAngleZ = 0F;
		BaseCadeau.renderWithRotation(par7);

		BasCadeauAvant.rotateAngleX = 0F;
		BasCadeauAvant.rotateAngleY = 0F;
		BasCadeauAvant.rotateAngleZ = 0F;
		BasCadeauAvant.renderWithRotation(par7);

		BasCadeauArriere.rotateAngleX = 0F;
		BasCadeauArriere.rotateAngleY = 0F;
		BasCadeauArriere.rotateAngleZ = 0F;
		BasCadeauArriere.renderWithRotation(par7);

		BasCadeauGauche.rotateAngleX = 0F;
		BasCadeauGauche.rotateAngleY = 0F;
		BasCadeauGauche.rotateAngleZ = 0F;
		BasCadeauGauche.renderWithRotation(par7);

		BasCadeauDroit.rotateAngleX = 0F;
		BasCadeauDroit.rotateAngleY = 0F;
		BasCadeauDroit.rotateAngleZ = 0F;
		BasCadeauDroit.renderWithRotation(par7);

		HautCadeau.rotateAngleX = 0F;
		HautCadeau.rotateAngleY = 0F;
		HautCadeau.rotateAngleZ = 0F;
		HautCadeau.renderWithRotation(par7);

		HautCadeauG.rotateAngleX = 0F;
		HautCadeauG.rotateAngleY = 0F;
		HautCadeauG.rotateAngleZ = 0F;
		HautCadeauG.renderWithRotation(par7);

		HautCadeauD.rotateAngleX = 0F;
		HautCadeauD.rotateAngleY = 0F;
		HautCadeauD.rotateAngleZ = 0F;
		HautCadeauD.renderWithRotation(par7);

		HautCadeauAvant.rotateAngleX = 0F;
		HautCadeauAvant.rotateAngleY = 0F;
		HautCadeauAvant.rotateAngleZ = 0F;
		HautCadeauAvant.renderWithRotation(par7);

		HautCadeauArriere.rotateAngleX = 0F;
		HautCadeauArriere.rotateAngleY = 0F;
		HautCadeauArriere.rotateAngleZ = 0F;
		HautCadeauArriere.renderWithRotation(par7);

		Noeud1.rotateAngleX = 0.0001745714F;
		Noeud1.rotateAngleY = 0F;
		Noeud1.rotateAngleZ = 0F;
		Noeud1.renderWithRotation(par7);

		Noeud2.rotateAngleX = 0.0001745714F;
		Noeud2.rotateAngleY = 0F;
		Noeud2.rotateAngleZ = 0F;
		Noeud2.renderWithRotation(par7);

		RubanH1.rotateAngleX = -0.0001745171F;
		RubanH1.rotateAngleY = 0F;
		RubanH1.rotateAngleZ = 0F;
		RubanH1.renderWithRotation(par7);

		RubanH2.rotateAngleX = -0.0001745171F;
		RubanH2.rotateAngleY = 0F;
		RubanH2.rotateAngleZ = 0F;
		RubanH2.renderWithRotation(par7);

		RubanH4.rotateAngleX = -0.0001745171F;
		RubanH4.rotateAngleY = 0F;
		RubanH4.rotateAngleZ = 0F;
		RubanH4.renderWithRotation(par7);

		RubanH3.rotateAngleX = -0.0001745171F;
		RubanH3.rotateAngleY = 0F;
		RubanH3.rotateAngleZ = 0F;
		RubanH3.renderWithRotation(par7);

		RubanTete1.rotateAngleX = 1.569332F;
		RubanTete1.rotateAngleY = -3.141593F;
		RubanTete1.rotateAngleZ = -3.141593F;
		RubanTete1.renderWithRotation(par7);

		RubanTete2.rotateAngleX = 1.569214F;
		RubanTete2.rotateAngleY = 3.141536F;
		RubanTete2.rotateAngleZ = 1.57072F;
		RubanTete2.renderWithRotation(par7);

		Ruban1.rotateAngleX = 0F;
		Ruban1.rotateAngleY = 0F;
		Ruban1.rotateAngleZ = 0F;
		Ruban1.renderWithRotation(par7);

		Ruban2.rotateAngleX = 0F;
		Ruban2.rotateAngleY = 0F;
		Ruban2.rotateAngleZ = 0F;
		Ruban2.renderWithRotation(par7);

		Ruban3.rotateAngleX = 0F;
		Ruban3.rotateAngleY = 0F;
		Ruban3.rotateAngleZ = 0F;
		Ruban3.renderWithRotation(par7);

		Ruban4.rotateAngleX = 0F;
		Ruban4.rotateAngleY = 0F;
		Ruban4.rotateAngleZ = 0F;
		Ruban4.renderWithRotation(par7);
	}
}
